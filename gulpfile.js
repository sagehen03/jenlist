'use strict';

var watchify = require('watchify');
var browserify = require('browserify');
var gulp = require('gulp');
var source = require('vinyl-source-stream');
var glob = require('glob');
var gutil = require('gulp-util');
var assign = require('lodash.assign');

var jsFiles =  glob.sync('./js/**/*.js');

// add custom browserify options here
var customOpts = {
    entries: jsFiles,
    debug: true,
    baseDir: './js'
};
var opts = assign({}, watchify.args, customOpts);
var b = watchify(browserify(opts));

gulp.task('bundle', bundle); // so you can run `gulp bundle` to build the file
b.on('update', bundle); // on any dep update, runs the bundler
b.on('log', gutil.log); // output build logs to terminal

function bundle() {
    return b.bundle()
        // log errors if they happen
        .on('error', gutil.log.bind(gutil, 'Browserify Error'))
        .pipe(source('bundle.js'))
        // optional, remove if you dont want sourcemaps
        // Add transformation tasks to the pipeline here.
        .pipe(gulp.dest('./build'));
}