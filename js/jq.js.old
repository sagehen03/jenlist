var App;
App = (function(){

    var mli;

    var autoComplete = $('#newItem');

    var commentsDialog;

    var newItemVal;

    var itemComments;

    function loadMasterListItemsToAutocomplete(){
        $.getJSON('http://localhost:8092/jenlist/master-list').then(function (data){
            mli = $.map(data, function(item){
                return item.name;
            });
        }).then(function() {
            autoComplete.autocomplete({
                source: mli
            });
        });
    }

    function autoCompleteEnterHandler(e){
        console.log("hello");
        if(e.which == 13){
            newItemVal = autoComplete.val();
            console.log(newItemVal);
            commentsDialog = $('#dialog').dialog({modal: true});
            $('#itemComments').on('keypress', commentsClickHandler);
            e.preventDefault();
        }
    }

    function commentsClickHandler(e){
        if(e.which == 13){
            var comments = $('#itemComments').val();
            if(comments){
                itemComments = comments;
                console.log(itemComments);
                e.preventDefault();
                commentsDialog.dialog('close');
            }
        }

    }

    function attachAutoCompleteEvents(){
        console.log("Zoom!");
        autoComplete.on("keypress", autoCompleteEnterHandler);
    }

    return {

        init: function(){
            console.log("Inside init");
            loadMasterListItemsToAutocomplete();
            attachAutoCompleteEvents();
            autoComplete.focus();
        },

        getMli: function(){
            return itemComments;
        }

    }
})();