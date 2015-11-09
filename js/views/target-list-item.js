(function(){
    'use strict';
    var Backbone = require("backbone");
    var _ = require('underscore');
    var template = _.template(
        '<span><%= name%></span>'
    );
    module.exports = Backbone.View.extend({

        template: template,
        tagName: 'li',

        render: function(){
            this.$el.html(this.template(this.model.toJSON()));
            this.$el.toggleClass('completed', this.model.get('completed'));
            return this;
        },

        initialize: function(){
        }
    });
})();