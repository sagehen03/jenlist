(function(){

    var shoppingListChanged = function(){
        $('#shoppingListForm').submit();
    };

    var checkBoxClicked = function(){
        var itemId = $(this).attr("id");
        var completed = $(this).is(":checked");
        $.get("updateItem?itemId="+itemId+"&completed="+completed, afterItemUpdated);
    }

    var afterItemUpdated = function(){
       var newHref = location.href.replace(/(name|category)Sort=(desc|asc)/g, "");
       location.href = newHref;
    };

    $(function(){
       $('#shoppingLists').on("change", shoppingListChanged);
       $("input:checkbox").on("click", checkBoxClicked);
       $('#use-a-list-nav').toggleClass('active');
    });

}());

