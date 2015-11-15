(function(){
    'use strict';
    var Backbone = require("backbone");
    var _ = require('underscore');
    var template = _.template(
        '<td><%= name%> <% if (comments) {%> (<%= comments%>) <%} %></td><td><%= category%></td><td><a href="#" class="delete"><span class="glyphicon glyphicon-remove"></span></a></td>'
    );
    module.exports = Backbone.View.extend({

        template: template,
        tagName: 'tr',

        events: {
            'click a.delete': 'removeItem'
        },

        removeItem: function(){
            this.model.destroy();
        },

        render: function(){
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },

        initialize: function(){
        }
    });
})();