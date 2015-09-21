/**
 * Created by guyazran on 9/18/15.
 */

/*
//Using Javascript
var request = new XMLHttpRequest();


//request.readyState
//this method returns the state of the request:
//1 - the request has been sent
//3 - downloading the response
//4 - content has been retrieved


request.onreadystatechange = function(){
    if(request.readyState === 4){
        if(request.status === 200) { //response ok
            var response = JSON.parse(request.response);
            document.getElementById("user-count").innerHTML = 'There are ' + response["user-count"] + ' users in the server';
        } else {
            throw new Error(request.response);
        }
    }
};

function getUserCount() {
    request.open('GET', '/MyFirstWebsite_war/MainServlet?admin=log');
    request.send();
};
*/

//using ajax

/*
//GET
var $usercount;

$(document).ready(function(){
    $usercount = $('#user-count');
});

function getUserCount(){
    $.ajax({
        type: 'GET',
        url: '/MyFirstWebsite_war/MainServlet?admin=log',
        success: function(data) {
            console.log(data);
            var json = $.parseJSON(data);
            $usercount.html('There are ' + json.usercount + ' users in the server');
        },
        error: function(){
            alert("error loading user count");
        }
    });
}
*/

//POST
var $usercount;

$(document).ready(function(){
    $usercount = $('#user-count');
});

function getUserCount(){
    var query = {
        'admin':'log'
    };

    $.ajax({
        type: 'POST',
        url: '/MyFirstWebsite_war/MainServlet',
        data: query,
        success: function(data) {
            console.log(data);
            var json = $.parseJSON(data);
            $usercount.html('There are ' + json.usercount + ' users in the server');
        },
        error: function(){
            alert("error loading user count");
        }
    });
}