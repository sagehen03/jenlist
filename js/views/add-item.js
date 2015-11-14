(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');

    module.exports = Backbone.View.extend({

        el: $('#add-item-area'),

        events: {
          'click #add-item': 'addItemToMasterList'
        },

        addItemToMasterList: function(){
            this.attributes.masterListColl.create({name: $('#new-master-item').val(),
                category: $('#categories').find(':selected').text()});
            $('#new-master-item').val('');

        },

        initialize: function(){
            this.listenToOnce(this.collection, 'sync', function(){
                this.collection.each(function (cat){
                    $('#categories').append('<option>' + cat.get('name') + '</option>');
                });

            });
            this.collection.fetch();
        }
    });
})();