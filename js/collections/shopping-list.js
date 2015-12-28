(function(){
    'use strict';
    var Backbone = require("backbone");
    var ListItem = require('../models/shopping-list-item');
    var BaseList = require('./base-list');
    module.exports = BaseList.extend({
        model: ListItem,

        selectedListId: null,

        initialize: function(){
            this.listenTo(Backbone, "masterListChanged", this.updateList);
            this.listenTo(Backbone, "addItemToTarget", this.addItemToList);
        },

        addItemToList: function(data){
            console.log("Creating new list item " + data);
            this.create(data, {wait: true, success: function(){
                console.log("Hello from success");
            }, error: function(e){
                console.log("hello from error");
            }});
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
            this.url = '/shopping-list-items/' + this.selectedListId;
        }

    });
})();