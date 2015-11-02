(function(){
    'use strict';
    var Backbone = require("backbone");
    module.exports = Backbone.Model.extend({
        defaults: {
            name: "",
            comments: "",
            dateAdded: "",
            completed: false
        }
    });
})();
