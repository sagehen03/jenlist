(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');
    var TLItem = require('./shopping-list-item');
    require('jquery-ui');

    module.exports = Backbone.View.extend({

        el: $('#shopping-list-area'),

        events: {
            'click th.sort': 'sortList',
            'click #remove-selected-items': 'deleteSelectedItems',
            'click #change-selected-items-status': 'toggleSelectedItems',
            'click #delete-all-items': 'deleteAllItemsFromList'
        },

        toggleSelectedItems: function(){
          this.collection.each(function(model){
             if(model.get("selected")){
                 var completed = model.get("completed");
                 model.set("completed", !completed);
                 model.save();
             }
          });
        },

        deleteAllItemsFromList: function(){
            var model;

            while (model = this.collection.first()) {
                model.destroy();
            }
        },

        deleteSelectedItems: function(){
            var selected = this.collection.where({selected:true});
            for(var i=0; i<selected.length; i++){
                selected[i].destroy();
            }
        },

        initialize: function () {
            this.listenTo(this.collection, 'add remove sort', this.render);
        },

        sortList: function(e){
            var sortBy = $(e.target).text().toLowerCase();
            this.collection.sortItems(sortBy);
        },

        render: function () {
            this.$('#shopping-list-body').empty();
            this.collection.each(function (item) {
                var tlItem = new TLItem({model: item});
                tlItem.render();
                this.$('#shopping-list-body').append(tlItem.el);
            }, this);
        }
    });
})();