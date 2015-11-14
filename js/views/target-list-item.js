(function(){
    'use strict';
    var Backbone = require("backbone");
    var _ = require('underscore');
    var template = _.template(
        '<td><%= name%> <% if (comments) {%> (<%= comments%>) <%} %></td><td><%= category%></td><td>Del</td>'
    );
    module.exports = Backbone.View.extend({

        template: template,
        tagName: 'tr',

        render: function(){
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },

        initialize: function(){
        }
    });
})();