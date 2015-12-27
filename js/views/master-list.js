(function(){
    'use strict';
    var Backbone = require("backbone");
    var Item = require('./master-list-item');
    var $ = require('jquery');
    var _ = require('underscore');

    module.exports = Backbone.View.extend({

        el: $('#master-list-area'),

        selected: false,

        events: {
          'focus' : '_setfocus',
          'blur' : '_losefocus',
          'click th.sort' : 'sortList',
          'blur #add-list-item-modal' : '_setfocus'
        },

        sortList: function(e){
            var sortBy = $(e.target).text().toLowerCase();
            this.collection.sortItems(sortBy);
        },

        initialize: function(){
            this.selected = false;
            this.listenToOnce(this.collection, 'sync', function(){
                this.render();
            });
            this.listenTo(this.collection, 'destroy add sort', this.render);
            this.collection.fetch();
            this.itemCommentsInput = $('#itemComments');
            var that = this;
            $('#add-list-item-modal').on('shown.bs.modal', function () {
                $('#add-list-item-modal-title').html(that.getSelectedItem().get('name'));
                $('#itemComments').focus();
            });

            $('#add-list-item-modal').on('hidden.bs.modal', function(){
                $('#master-list-area').focus();
            });


            _.bindAll(this, 'keydown');
            $(document).on('keydown', this.keydown);
            _.bindAll(this, 'keyDownInDialog');
            this.itemCommentsInput.on('keydown', this.keyDownInDialog);
        },

        keyDownInDialog: function(e){
            if(e.which == 13){
                this.addItemToList();
                return false;
            }
        },

        addItemToList: function(){
            var itemToAdd = this.getSelectedItem();
            Backbone.trigger("addItemToTarget", {"name":  itemToAdd.get('name'),
                "category": itemToAdd.get('category'),
                "comments": this.itemCommentsInput.val()});
            this.itemCommentsInput.val('');
            $('#add-list-item-modal').modal('hide');
        },

        getSelectedItem: function(){
            return this.collection.find(function (i) {
                return i.get('selected');
            });
        },

        isSelected: function(){
            return this.selected;
        },

        _losefocus: function (e) {
            var relatedTarget = e.relatedTarget || document.activeElement;
            if(relatedTarget == $('#add-list-item-modal')[0]
                || ($(relatedTarget).attr("class") && $(relatedTarget).attr("class").indexOf("modal") > -1)){
                return;
            }
            this.selected = false;
            this.collection.clearSelection();
        },

        _setfocus: function(){
            this.selected = true;
        },

        keydown: function(e){

            if ( !this.selected ){
                return;
            }

            var collection = this.collection;

            if( e.which == 40 ) {
                collection.selectedItem++;
                if( !collection.at( collection.selectedItem ) ){
                    collection.selectedItem = 0;
                }
                var item = collection.at(collection.selectedItem);
                collection.clearSelection();
                item.set('selected', true);
                if(collection.selectedItem == 0){
                    $('#master-list-area').scrollTop(0);
                } else {
                    $('#master-list-area').scrollTop($('#master-list-area').scrollTop() + 37);
                }
                return false;
            }

            if (e.which == 13) {
                $('#add-list-item-modal').modal('show');
                return false;
            }

            if ( e.which == 38 ){
                collection.selectedItem--;
                if( collection.selectedItem < 0 ){
                    collection.selectedItem = collection.size() - 1;
                }
                var item = collection.at(collection.selectedItem);
                collection.clearSelection();
                item.set('selected', true);
                if(collection.selectedItem == collection.size() - 1){
                    $('#master-list-area').scrollTop(630);
                } else {
                    $('#master-list-area').scrollTop($('#master-list-area').scrollTop() - 37);
                }
                return false;
            }
        },

        render: function() {
            $('#make-a-list-nav').toggleClass('active');
            $('#master-list-body').empty();
            this.collection.each(function (item){
                var item2 = new Item({model: item, collection: this.collection}).render();
                this.$('#master-list-body').append(item2.el);
            }, this);
        }
    });
})();