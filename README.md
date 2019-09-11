# Taskmaster

## [Endpoint](http://taskmaster-dev-2.us-west-2.elasticbeanstalk.com/api/v1/tasks)

### Available Routes
* GET: `/api/v1/tasks` - returns all tasks from the db in `json` format.
* POST: `/api/v1/tasks` - takes in `json` data in the post body to create a new task.
    * Example post request
        ```
        {
            "title": "submit assignment",
            "description": "submit it and get some points!"
        }
        ```
* PUT: `/api/v1/tasks/{id}/state` - takes in a task `id` as a path variable, and updates that task to the next status.
    * Statuses progress from:  `Available` -> `Assigned` -> `Accepted` -> `Finished`.

