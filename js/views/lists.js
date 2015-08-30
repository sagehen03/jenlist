var Backbone = require('backbone');
var _ = require('underscore');
var $ = require('jquery');

module.exports = Backbone.View.extend({
    template: require('./templates/lists.jade'),

    initialize: function() {
        this.listenToOnce(this.collection, 'sync', function() {
            // Initial render.
            this.render()

            // Rerender on subsequent add/remove events.
            this.listenTo(this.collection, 'add remove', this.render);
        });

        // Get the data.
        this.collection.fetch();
    },

    render: function () {
        this.$el.html(this.template({
            lists: this.collection.toJSON()
        }));
        return this;
    }
});
