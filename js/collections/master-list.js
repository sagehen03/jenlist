'use strict';

var env = require('../env');
var Backbone = require("backbone");
var MasterListItem = require('../models/master-list-item');

var MasterList = Backbone.Collection.extend({

    model: MasterListItem,
    url: env.API_BASE + '/master-list'

});
module.exports = MasterList;
