(function(){
    'use strict';
    var Backbone = require("backbone");
    var env = require('../env');
    var ListItem = require('../models/shopping-list-item');
    var BaseList = require('./base-list');
    module.exports = BaseList.extend({
        model: ListItem,

        selectedListId: null,

        initialize: function(){
            this.listenTo(Backbone, "masterListChanged", this.updateList);
            this.listenTo(Backbone, "addItemToTarget", this.create);
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
            this.url = env.API_BASE + '/shopping-list-items/' + this.selectedListId;
        }

    });
})();