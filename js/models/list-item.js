(function(){
    'use strict';
    var Backbone = require("backbone");
    var ListItem = Backbone.Model.extend({
        defaults: {
            title: "",
            comments: "",
            completed: false
        }
    });
    module.exports = ListItem;
})();
