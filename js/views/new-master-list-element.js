(function(){
    'use strict';
    var Backbone = require("backbone");
    var _ = require('underscore');
    var template = _.template(
        '<span><%= name%></span>'
    );
    module.exports = Backbone.View.extend({
        events: {
            'click': 'click'
        },

        template: template,
        tagName: 'li',

        click: function(){
            this.collection.clearSelection();
            this.model.set('selected', true);
            for(var i=0; i<this.collection.models.length; i++){
                if(this.collection.models[i] == this.model){
                    break;
                }
            }
            this.collection.selectedItem = i;
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