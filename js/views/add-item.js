(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');

    module.exports = Backbone.View.extend({

        el: $('#add-item-area'),

        events: {
          'click #add-item': 'addItemToMasterList',
          'click #add-category': 'showAddCategoryModal'
        },

        addItemToMasterList: function(e){
            this.attributes.masterListColl.create({name: $('#new-master-item').val(),
                category: $('#categories').find(':selected').text()});
            $('#new-master-item').val('');
            e.preventDefault();
        },

        initialize: function(){
            this.listenTo(this.collection, 'sync add', function(){
                $('#categories').empty();
                this.collection.sort();
                this.collection.each(function (cat){
                    $('#categories').append('<option>' + cat.get('name') + '</option>');
                });

            });
            this.collection.fetch();
            $('#add-category-modal').on('shown.bs.modal', function () {
                $('#new-category-name').focus();
            });
            var that = this;

            $('#new-category-name').on('keydown', function(e){
                if(e.which == 13){
                    var newCategory = $('#new-category-name').val();
                    that.collection.create({name: newCategory});
                    $('#new-category-name').val('');
                    $('#add-category-modal').modal('hide');
                    e.preventDefault();
                }
            });
        },

        showAddCategoryModal: function(e){
            $('#add-category-modal').modal('show');
            e.preventDefault();
        }
    });
})();