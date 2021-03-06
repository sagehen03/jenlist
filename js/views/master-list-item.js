(function(){
    'use strict';
    var Backbone = require("backbone");
    var _ = require('underscore');
    var $ = require('jquery');
    var template = _.template(
        '<td><%= name%></td><td><%= category %></td><td><a href="#" class="delete"><span class="glyphicon glyphicon-remove"></span></a></td>'
    );
    module.exports = Backbone.View.extend({
        events: {
            'dblclick': 'dblClick',
            'click a.delete': 'removeItem'
        },

        template: template,
        tagName: 'tr',

        removeItem: function(){
          this.model.destroy();
        },

        dblClick: function(){
            this.collection.clearSelection();
            this.model.set('selected', true);
            for(var i=0; i<this.collection.models.length; i++){
                if(this.collection.models[i] == this.model){
                    break;
                }
            }
            this.collection.selectedItem = i;
            $('#add-list-item-modal').modal('show');
        },

        render: function(){
            this.$el.html(this.template(this.model.toJSON()));
            this.$el.toggleClass('selected', this.model.get('selected'));
            return this;
        },

        initialize: function(){
            this.listenTo(this.model, 'change:selected', this.render);
        }
    });
})();