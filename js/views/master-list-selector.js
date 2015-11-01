var Backbone = require('backbone');
var _ = require('underscore');
var $ = require('jquery');

module.exports = Backbone.View.extend({
    template: _.template('<option value="<%=id%>"><%=name%></option>'),

    el: '<select id="targetList">',

    initialize: function() {
        this.listenToOnce(this.collection, 'sync', function() {
            // Initial render.
            this.render();

            // Rerender on subsequent add/remove events.
            this.listenTo(this.collection, 'add remove', this.render);
        });

        // Get the data.
        this.collection.fetch();
    },

    render: function () {
        $('#target-list').append(this.el);
        this.collection.each(function (list){
            this.$el.append(this.template(list.toJSON()));
        }, this);
        return this;
    }
});