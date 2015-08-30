var MasterListItemView = require('../views/master-list-item');
var Backbone = require('backbone');


var MasterListView = Backbone.View.extend({
    tagName: 'ul',
    className: 'list-unstyled',

    events: {
        'change input': 'selected'
    },

    initialize: function(){
        this.listenToOnce(this.collection, 'sync', function() {
            // Initial render.
            this.render()

            // Rerender on subsequent add/remove events.
            this.listenTo(this.collection, 'add remove', this.render);
        });

        // Fetch data.
        this.collection.fetch();
    },

    render: function(){
        var mlView = this.collection.map(function(item){
            return (new MasterListItemView({model: item})).render().el;
        });
        this.$el.html(mlView);
        return this;
    },

    addItem: function(item){
        var view = new MasterListItemView({
            model: item
        });
        this.$el.append(view.el);
        view.render();
        return this;
    }

});
module.exports = MasterListView;
