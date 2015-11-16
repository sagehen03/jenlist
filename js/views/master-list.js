(function(){
    'use strict';
    var Backbone = require("backbone");
    var Item = require('./master-list-item');
    var $ = require('jquery');
    require('jquery-ui');

    module.exports = Backbone.View.extend({

        el: $('#master-list-area'),

        selected: false,

        events: {
          'focus' : '_setfocus',
          'focusout' : '_losefocus',
          'click th.sort' : 'sortList'
        },

        sortList: function(e){
            var sortBy = $(e.target).text().toLowerCase();
            this.collection.sortItems(sortBy);
        },

        initialize: function(){
            this.selected = false;
            this.commentsDialog = $('#dialog');
            this.listenToOnce(this.collection, 'sync', function(){
                this.render();
            });
            this.listenTo(this.collection, 'destroy add sort', function(){
                this.render();
            });
            this.collection.fetch();
            var itemCommentsInput = $('#itemComments');
            $(document).on('keydown', {view: this}, this.keydown);
            itemCommentsInput.on('keydown', {view: this, selectedItem: this.getSelectedItem},
                function(e){
                    var view = e.data.view;
                    if(e.which == 13){
                        var itemToAdd = e.data.selectedItem(view);
                        Backbone.trigger("addItemToTarget", {"name":  itemToAdd.get('name'), "category": itemToAdd.get('category'),
                             "comments": itemCommentsInput.val()});
                        itemCommentsInput.val('');
                        view.commentsDialog.dialog('close');
                        return false;
                    }
            });
        },

        getSelectedItem: function(view){
            return view.collection.find(function (i) {
                return i.get('selected');
            });
        },

        isSelected: function(){
            return this.selected;
        },

        _losefocus: function (e) {
            if(e.relatedTarget == $('#itemComments')[0]){
                return;
            }
            this.selected = false;
            this.collection.clearSelection();
        },

        _setfocus: function(){
            this.selected = true;
        },

        keydown: function(e){
            var view = e.data.view;

            if ( !view.selected ){
                return;
            }

            var collection = view.collection;

            if( e.which == 40 ) {
                collection.selectedItem++;
                if( !collection.at( collection.selectedItem ) ){
                    collection.selectedItem = 0;
                }
                var item = collection.at(collection.selectedItem);
                collection.clearSelection();
                item.set('selected', true);
            }

            if (e.which == 13) {
                view.commentsDialog.dialog({show: true, title: view.getSelectedItem(view).get('name')});

                return false;
            }

            if ( e.which == 38 ){
                collection.selectedItem--;
                if( !collection.at( collection.selectedItem ) ){
                    collection.selectedItem = collection.size() - 1;
                }
                var item = collection.at(collection.selectedItem);
                collection.clearSelection();
                item.set('selected', true);
            }
        },

        render: function(){
            console.log("inside render");
            $('#master-list-body').empty();
            var coll = this.collection;
            this.collection.each(function (item){
                var item2 = new Item({model: item, collection: coll}).render();
                this.$('#master-list-body').append(item2.el);
            }, this);
        }
    });
})();