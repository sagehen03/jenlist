(function(){
    'use strict'
    var Backbone = require('backbone');
    var _ = require('underscore');
    var $ = require('jquery')
    var MasterListItemView = Backbone.View.extend({
        tagName:  'li',
        className: 'masterListItem',
        template: '<%= name %>',

        render: function () {
            var tmpl = _.template(this.template);
            this.$el.html(tmpl(this.model.toJSON()));
            return this;
        }
    });
    module.exports = MasterListItemView;

})();