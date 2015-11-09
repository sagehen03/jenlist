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
            this.listenTo(Backbone, "addItemToTarget", this.newItem);
            //this.listenTo(this.selectedList, 'change:id', this.updateUrl)
        },

        newItem: function(data){
          this.create(data);
        },

        updateList: function(e){
            this.selectedListId = e.selectedListId;
            this.updateUrl();
            var that = this;
            this.fetch({success: function(){
                that.trigger('change:selectedListId', {"selectedListId": that.selectedListId});
            }});
        },

        updateUrl: function(){
            this.url = env.API_BASE + '/shopping-list/' + this.selectedListId;
        }

    });
})();