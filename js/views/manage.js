var Backbone = require('backbone');
var _ = require('underscore');
var NewMasterListItem = require('./new-master-list-item');
var ListsCollection = require('../collections/lists');
var ListItems = require('../collections/list-items');


module.exports = Backbone.View.extend({
    template: require('./templates/manage.jade'),

    events: {
        'submit form': 'handleSubmit',
    },

    initialize: function() {
        this.lists = new ListsCollection();
        this.listenToOnce(this.lists, 'sync', function() {
            // Initial render.
            this.render()

            // Rerender on subsequent add/remove events.
            this.listenTo(this.lists, 'add remove', this.render);
        });
        this.lists.fetch()

        // Listen for someone selecting an item in the list.
        this.listenTo(this.collection, 'change:selected', this.render);
    },

    handleSubmit: function (e) {
        e.preventDefault();
        var isSelected = (this.collection.find({selected: true})) != null;
        if (isSelected) {
            var listId = this.$('select').val();
            var items = _.where(this.collection.toJSON(), {selected: true});
            this.addToList(listId, items);
        } else {
            this.createMasterItem({
                name: this.$('input').val().trim()
            });
        }

        this.render();
    },

    addToList: function(listId, items) {
        var list = new ListItems(items, {
            id: listId
        })
        // TODO: Listen for when this fails.
        list.batch();
    },

    createMasterItem: function(data) {
        if (data) {
            // TODO: Handle when this fails to add.
            this.collection.create(data);
        }
    },

    render: function () {
        this.$el.html(this.template({
            items: this.collection.toJSON(),
            lists: this.lists.toJSON(),
            isSelected: (this.collection.find({selected: true})) != null
        }));
        return this;
    }
});
