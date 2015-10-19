var App = (function () {
       var sampleItems = [{id: 1, name: "tomatoes"},
                        {id: 2, name: "corn"},
                        {id: 3, name: "potatoes"},
                        {id: 4, name: "peas"},
                        {id: 5, name: "carrots"},
                        {id: 6, name: "onions"},
                        {id: 7, name: "garlic"},
                        {id: 8, name: "squash"}],
           keyPressInProgress = false,
           selectedItem,
           listSelected,
           commentsDialog,
           handleKeydown, arrowDown, arrowUp, enterPressed,
           layoutItems, addItemClickHandler, addListClickHandler, init;

    layoutItems = function(){
        $.each( sampleItems, function ( index, val ){
            $('#list').append('<li>' + val.name + '</li>');
        });

    };

    arrowDown = function () {
        if (selectedItem) {
            selectedItem.removeClass('selected');
            var next = selectedItem.next();
            if (next.length > 0) {
                selectedItem = next.addClass('selected');
            } else {
                selectedItem = $('li').eq(0).addClass('selected');
            }
        } else {
            selectedItem = $('li').eq(0).addClass('selected');
        }
    };

    arrowUp = function () {
        if (selectedItem) {
            selectedItem.removeClass('selected');
            var next = selectedItem.prev();
            if (next.length > 0) {
                selectedItem = next.addClass('selected');
            } else {
                selectedItem = $('li').last().addClass('selected');
            }
        } else {
            selectedItem = $('li').last().addClass('selected');
        }
    };

    enterPressed = function() {
        if( !selectedItem ) {
            return false;
        }
        if( !commentsDialog ) {
            commentsDialog = $('#dialog').dialog({modal: true});
            $( commentsDialog ).on( 'keydown', function ( event ) {
                if ( event.which == 13) {
                    if (keyPressInProgress) {
                        return false;
                    }
                    keyPressInProgress = true;
                    var comments = $('#itemComments').val();
                    if(comments) {
                        console.log(comments + ' ' + selectedItem.text());
                    } else {
                        console.log('write to db now! ' + selectedItem.text());
                    }
                    commentsDialog.dialog('close');
                    $(  '#itemComments').val('');
                    keyPressInProgress = false;
                    return false;
                }
            });
        } else {
            commentsDialog.dialog({modal: true});
        }
        return false;
    };

    handleKeydown = function( event ) {
        if( !listSelected ){
            return false;
        }
        if( event.which == 40) {
            arrowDown();
        } else if ( event.which == 38 ){
            arrowUp();
        } else if (event.which == 13){
            enterPressed();
            return false;
        }
    };

    addListClickHandler = function() {
        $(window).on( 'keydown', handleKeydown);
    };

    addItemClickHandler = function () {
        $( 'ul').on( 'click', function () {
            listSelected = true;
            return false;
        });

        $(window).on( 'click', function () {
            listSelected = false;
            return true;
        })
    };

    init = function () {
        layoutItems();
        addItemClickHandler();
        addListClickHandler();
    };

    return {init: init};

})();