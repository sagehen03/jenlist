(function(){
    'use strict';
    var Backbone = require("backbone");
    var env = require('../env');
    var ListItem = require('../models/target-list-item')
    module.exports = Backbone.Collection.extend({
        model: ListItem,

        selectedListId: null,

        initialize: function(){
            this.listenTo(Backbone, "masterListChanged", this.updateList);
            //this.listenTo(this.selectedList, 'change:id', this.updateUrl)
        },

        updateList: function(e){
            this.selectedListId = e.selectedListId;
            this.updateUrl();
        },

        updateUrl: function(){
            this.url = env.API_BASE + '/shopping-list/' + this.selectedListId;
        }

    });
})();