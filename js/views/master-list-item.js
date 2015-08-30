(function(){
    'use strict'
    var Backbone = require('backbone');
    var _ = require('underscore');
    var MasterListItemView = Backbone.View.extend({
        tagName:  'li',
        className: 'masterListItem',
        template: '<%= name %> <a href="#" class="removeItem">x</a>',

        events: {
            'click .removeItem': 'removeItem'
        },

        removeItem: function(){
            console.log("inside remove item for " + this.model.toJSON());
            this.model.destroy();
        },

        render: function () {
            var tmpl = _.template(this.template);
            this.$el.html(tmpl(this.model.toJSON()));
            return this;
        }
    });
    module.exports = MasterListItemView;

})();