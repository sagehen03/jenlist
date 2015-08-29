(function(){
    'use strict';
    var Backbone = require("backbone");
    var MasterListItem = Backbone.Model.extend({
        defaults: {
            name: "",
            id: 0,
            dateAdded: ""
        }
    });
    module.exports = MasterListItem;
})();
