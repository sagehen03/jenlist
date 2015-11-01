(function(){
    'use strict';
    var Backbone = require("backbone");
    var NewMasterListItem = require('../models/new-master-list-item')
    module.exports = Backbone.Collection.extend({
        model: NewMasterListItem,

        clearSelection: function() {
            this.each(function (model){
               model.set('selected', false);
            });
        }
    });
})();