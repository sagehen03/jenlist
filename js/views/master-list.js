(function(){
    'use strict'
    var MasterListItemView = require('views/master-list-item');
    var mlColl = require('collections/master-list');
    var Backbone = require('backbone');
    var MasterListView = Backbone.View.extend({
        el: '#master-list',
        collection: mlColl,

        initialize: function(){
          console.log("Master List View Created");
        },

        render: function(){
            var mlView = this.collection.map(function(item){
                return (new MasterListItemView({model: item})).render().el;
            });
            this.$el.html(mlView);
            return this;
        }
    });
    module.exports = MasterListView;
})();