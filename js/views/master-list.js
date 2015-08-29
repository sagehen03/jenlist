(function(){
    'use strict'
    var MasterListItemView = require('views/master-list-item');
    var MasterList = require('collections/master-list');
    var Backbone = require('backbone');
    var MasterListView = Backbone.View.extend({
        el: '#master-list',
        collection: new MasterList(),

        initialize: function(){
          var that = this;
          this.collection.fetch({success: function(){
              that.render();
          }});
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