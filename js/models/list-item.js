(function(){
    'use strict';
    var Backbone = require("backbone");
    var ListItem = Backbone.Model.extend({
        defaults: {
            title: "",
            comments: "",
            dateAdded: "",
            completed: false
        }
    });
    console.log("Hello hello");
    module.exports = ListItem;
})();
