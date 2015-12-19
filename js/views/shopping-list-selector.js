var Backbone = require('backbone');
var _ = require('underscore');
var $ = require('jquery');

module.exports = Backbone.View.extend({
    template: _.template('<option value="<%=id%>"><%=name%></option>'),

    el: $('#new-list-form'),

    events : {
      'change #shoppingLists' : "masterListChanged",
      'click #show-add-list' : "showAddListModal",
      'click #add-new-list-btn' : "addNewList",
      'keydown #add-list-modal' : "keydown"
    },

    initialize: function(){
        _.bindAll(this, "keydown");
    },

    keydown: function(e){
        if(e.which == 13){
            this.addNewList();
            return false;
        }
    },

    showAddListModal: function(){
        $('#add-list-modal').modal('show');
    },

    addNewList: function(){
        if($('#new-shopping-list').val()) {
            Backbone.trigger("newShoppingList", {"name": $('#new-shopping-list').val()});
            $('#new-shopping-list').val('');
            $('#add-list-modal').modal('hide');
        } else {
            alert("Enter a name for the list, yo");
        }
    },

    masterListChanged: function() {
        var chosenListId = $('#shoppingLists').val();
        Backbone.trigger("masterListChanged", {"selectedListId": chosenListId});
    },

    initialize: function() {
        $('#add-list-modal').on('shown.bs.modal', function () {
            $('#new-shopping-list').focus();
        });

        this.listenTo(this.collection, 'sync', function() {
            this.render();
            this.masterListChanged();
        });

        this.collection.fetch();
    },

    render: function () {
        var $lists = $('#shoppingLists');
        $lists.html('');
        this.collection.each(function (list){
            $lists.append(this.template(list.toJSON()));
        }, this);
        return this;
    }
});
