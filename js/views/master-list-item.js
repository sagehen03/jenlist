var Backbone = require('backbone');
var _ = require('underscore');


var MasterListItemView = Backbone.View.extend({
    tagName:  'li',
    className: 'masterListItem',
    template: require('./templates/list-item.jade'),

    events: {
        'click .removeItem': 'removeItem'
    },

    removeItem: function(){
        console.log("inside remove item for " + this.model.toJSON());
        this.model.destroy();
    },

    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});
module.exports = MasterListItemView;
