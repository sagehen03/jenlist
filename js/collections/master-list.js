(function () {
    'use strict';
    var NewMasterListItem = require('../models/master-list-item');
    var BaseList = require('./base-list');
    module.exports = BaseList.extend({
        model: NewMasterListItem,
        url: 'http://localhost:8092/jenlist/master-list',

        clearSelection: function () {
            this.each(function (model) {
                model.set('selected', false);
            });
        }
    });
})();