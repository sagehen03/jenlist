(function(){
    'use strict';
    var Backbone = require("backbone");
    var MasterListItem = Backbone.Model.extend({
        defaults: {
            name: "Hello Dolly",
            dateAdded: ""
        }
    });
    module.exports = MasterListItem;
})();
