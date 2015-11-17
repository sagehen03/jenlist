(function(){
    'use strict';
    var Backbone = require("backbone");
    module.exports = Backbone.Model.extend({
        defaults: {
            name: "",
            comments: "",
            shoppingListId: 0,
            category: "",
            dateAdded: "",
            completed: false
        }
    });
})();
