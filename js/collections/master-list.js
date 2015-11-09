(function(){
    'use strict';
    var Backbone = require("backbone");
    var NewMasterListItem = require('../models/master-list-item')
    module.exports = Backbone.Collection.extend({
        model: NewMasterListItem,
        url: 'http://localhost:8092/jenlist/master-list',

        clearSelection: function() {
            this.each(function (model){
               model.set('selected', false);
            });
        }
    });
})();