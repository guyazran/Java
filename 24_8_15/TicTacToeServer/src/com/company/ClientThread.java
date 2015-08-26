package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.AbstractCollection;
import java.util.ArrayList;

/**
 * Created by guyazran on 8/25/15.
 */
public class ClientThread extends Thread {

    public static final int JOIN_GAME = 10;
    public static final int MAKE_MOVE = 20;
    public static final int VICTORY = 30;
    public static final int LEAVE_GAME = 40;
    public static final int YOU_ARE_PLAYER_ONE = 50;
    public static final int YOU_ARE_PLAYER_TWO = 60;
    public static final int GAME_IS_FULL = 70;
    public static final int GAME_READY = 80;
    public static final int WAIT_FOR_OTHER_PLAYER = 90;
    public static final int CHECK_FOR_OPPONENT_MOVE = 110;
    public static final int SUCCESS = 120;
    public static final int FAILURE= 130;
    public static final int CHECK_GAME_READY = 140;
    public static final int RESTART_GAME = 150;

    private Socket clientSocket;
    private ArrayList<Game> games;
    private InputStream inputStream;
    private OutputStream outputStream;

    public ClientThread(Socket clientSocket, ArrayList<Game> games){
        this.clientSocket = clientSocket;
        this.games = games;
        inputStream = null;
        outputStream = null;
    }

    @Override
    public void run() {
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            int action = inputStream.read();

            switch (action){
                case JOIN_GAME:
                    joinGame();
                    break;
                case CHECK_GAME_READY:
                    checkGameReady();
                    break;
                case MAKE_MOVE:
                    makeMove();
                    break;
                case CHECK_FOR_OPPONENT_MOVE:
                    checkForOpponentMove();
                    break;
                case VICTORY:
                    victory();
                    break;
                case RESTART_GAME:
                    restartGame();
                    break;
                case LEAVE_GAME:
                    leaveGame();
                    break;
            }


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void joinGame() throws IOException {
        if (!games.get(0).player1) {
            games.get(0).player1 = true;
            outputStream.write(YOU_ARE_PLAYER_ONE);
        } else if (!games.get(0).player2) {
            games.get(0).player2 = true;
            outputStream.write(YOU_ARE_PLAYER_TWO);
        } else {
            outputStream.write(GAME_IS_FULL);
        }

    }

    void checkGameReady() throws IOException {
        if (games.get(0).player1 && games.get(0).player2) {
            outputStream.write(GAME_READY);
        } else {
            outputStream.write(WAIT_FOR_OTHER_PLAYER);
        }
    }

    void makeMove() throws IOException {
        synchronized (games.get((0))) {
            games.get(0).moveCell = inputStream.read();
        }
    }

    void checkForOpponentMove() throws IOException {
        synchronized (games.get((0))) {
            if (games.get(0).moveCell == -1) {
                outputStream.write(FAILURE);
            } else {
                outputStream.write(SUCCESS);
                outputStream.write(games.get(0).moveCell);
                games.get(0).moveCell = -1;
            }
        }
    }

    void victory() throws IOException {
        games.get(0).player1 = false;
        games.get(0).player2 = false;
    }

    void restartGame() throws IOException {
        int player = inputStream.read();
        if (player == YOU_ARE_PLAYER_ONE){
            games.get(0).player1 = true;
        } else if (player == YOU_ARE_PLAYER_TWO){
            games.get(0).player2 = true;
        }
    }

    void leaveGame() throws IOException {
        int player = inputStream.read();
        if (player == YOU_ARE_PLAYER_ONE){
            games.get(0).player1 = false;
        } else if (player == YOU_ARE_PLAYER_TWO){
            games.get(0).player2 = false;
        } else {
            outputStream.write(FAILURE);
            return;
        }
        outputStream.write(SUCCESS);
    }
}
