(function(){
    'use strict';
    var Backbone = require("backbone");
    var MasterListItem = require('models/master-list-item');
    var MasterList = Backbone.Collection.extend({

        model: MasterListItem,
        url: 'http://localhost:8092/jenlist/master-list'

    });
    module.exports = MasterList;
})();