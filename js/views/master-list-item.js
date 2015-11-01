var Backbone = require('backbone');
var _ = require('underscore');


var MasterListItemView = Backbone.View.extend({
    tagName:  'li',
    className: 'list-item',
    template: require('./templates/list-item.jade'),

    events: {
        'click .remove': 'removeItem',
        'change input': 'select',
        'click span': 'itemClick'
    },

    removeItem: function(){
        console.log("inside remove item for " + this.model.toJSON());
        this.model.destroy();
    },

    itemClick: function(){
        //show comment options

        console.log(this.model.get('name'));
    },

    select: function() {
        this.model.set('selected', this.$('input').prop('checked'));
    },

    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});
module.exports = MasterListItemView;
