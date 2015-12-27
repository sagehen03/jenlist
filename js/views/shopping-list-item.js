(function(){
    'use strict';
    var Backbone = require("backbone");
    var _ = require('underscore');
    var template = _.template(
        '<td><input type="checkbox" id="<%=id%>" <% if (completed) {%> checked="checked" <%} %> > &nbsp;' +
        '<label <% if (completed) {%> class="completed" <%} %> for="<%=id%>"> <%= name%> <% if (comments) {%> (<%= comments%>) <%} %></label></td>' +
        '<td><%= category%></td><td><a href="#" class="delete"><span class="glyphicon glyphicon-remove"></span></a></td>'
    );
    module.exports = Backbone.View.extend({

        template: template,
        tagName: 'tr',

        events: {
            'click a.delete': 'removeItem',
            'click [type=checkbox]': 'toggleCompleted'
        },

        initialize: function(){
            _.bindAll(this, 'toggleCompleted');
            this.listenTo(this.model, 'change:completed', this.render);
        },

        removeItem: function(){
            this.model.destroy();
        },

        toggleCompleted: function(){
          var completed = this.model.get('completed');
          this.model.set('completed', !completed);
          this.model.save();
        },

        render: function(){
            console.log("Rendering");
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
    });
})();
