var rootPath = 'http://localhost:8080/cellar/webresources/entity.wine';
var currentWine;


function findById(id){
    $.ajax({
        url: rootPath + '/' + id,
        type: 'GET',
        dataType: 'json', 
        success: function(data) {
            renderWine(data);
            $('#btnDelete').show();
        }
    });
}

function findByName(name){
    var realUrl;
    if(name != ''){
        realUrl = rootPath + '/name/' + name;
    }else{
        realUrl = rootPath + '/';
    }
    
    $.ajax({
        url: realUrl,
        type: 'GET',
        dataType: 'json', 
        success: function(data) {
            renderWineList(data);
        }
    });
}

function updateWine(){
    console.log('try to update wine ' + $('#wineId').val());
    
    $.ajax({
        url: rootPath,
        type: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        data: formToJSON(),
        success: function(data) {
            alert("wine upated");
        },
        error: function(data) {
            alert("bad luck");
        }
    });
}

function saveWine(){
    console.log('try to add wine ');
    
    $.ajax({
        url: rootPath,
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: formToJSON(),
        success: function(data) {
            alert("wine added");
            findByName('');
        },
        error: function(data) {
            alert("bad luck");
        }
    });
}

function deleteWine(){
    console.log('try to delete wine ');
    
    $.ajax({
        url: rootPath + '/' + $('#wineId').val(),
        type: 'DELETE',
        success: function(data) {
            alert("wine deleted");
            findByName('');
            clearWineForm();
        },
        error: function(data) {
            alert("bad luck");
        }
    }); 
}



function renderWineList(data){
    $('#wineList li').remove();
    
    $.each(data, function(i, wine){
        console.log(wine);
        $('#wineList').append('<li><a href="#" data-wineid="' + wine.id + '">' + wine.name +'</a></li>');
    })
}

function renderWine(data){
    $('#wineId').val(data.id);
    $('#name').val(data.name);
    $('#grapes').val(data.grapes);
    $('#country').val(data.country);
    $('#region').val(data.region);
    $('#year').val(data.year);
    $('#pic').attr('src', "pics/" + data.picture );
    $('#description').val(data.description);
}
function clearWineForm(){
    $('#wineId').val('');
    $('#name').val('');
    $('#grapes').val('');
    $('#country').val('');
    $('#region').val('');
    $('#year').val('');
    $('#pic').attr('src', "pics/bouscat.jpg" );
    $('#description').val('');
}

function formToJSON() {
    return JSON.stringify({
        "id": $('#wineId').val(),
        "name": $('#name').val(),
        "grapes": $('#grapes').val(),
        "country": $('#country').val(),
        "region": $('#region').val(),
        "year": $('#year').val(),
        "description": $('#description').val()
       // "picture": $('#pic').attr('src').val().substr(4)
    });
}

function init() { 
    console.log("initialisation");
   
    $('#btnDelete').hide();
    
    $('#btnDelete').click(function(){
        deleteWine();
        
        return false;
    });
    
    $('#btnAdd').click(function(){
        clearWineForm();
        $('#btnDelete').hide();
        return false;
    });
    
    $('#btnSave').click(function(){
        if($('#wineId').val() != 0){
            updateWine();
            
        }else{
            saveWine();
        }
        
        return false;
    });
   
    $('#btnSearch').click(function(){
        findByName($('#searchKey').val());
        return false;
    });
    
    $('#searchKey').keyup(function(){
        findByName($('#searchKey').val());
    });
   

    $('#wineList a').live('click', function(){
        findById($(this).data("wineid"));
        return false;
    })
    
    findByName('');
}

// Once DOM tree ready we can play
$(document).ready(init);

