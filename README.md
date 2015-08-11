![rv-adapter-states on Travis CI](https://travis-ci.org/rockerhieu/rv-adapter-states.png?branch=master) ![rv-adapter-states on Maven Central](https://maven-badges.herokuapp.com/maven-central/com.rockerhieu/rv-adapter-states/badge.svg)

## rv-adapter-states

`RecyclerView.Adapter` is often used to render a list of items from a remote resource, i.e external API. In that case you have to deal with different states of the data such as:
* The data is being fetched (loading state)
* There is no data (empty state)
* There was an error when getting the data (error state)

`StatesRecyclerViewAdapter` helps to manage these states easily without changing the existing adapter.

## Installation

```groovy
compile 'com.rockerhieu:rv-adapter-states:<latest-version>'
```

## Usage

To use `StatesRecyclerViewAdapter` you need to create a subclass that will control the states, specifying what views to use for the loading, empty and error placeholder.

```java
Adapter adapter = new SimpleStringAdapter(null);
StatesRecyclerViewAdapter statesRecyclerViewAdapter = new StatesRecyclerViewAdapter(adapter, loadingView, emptyView, errorView);
rv.setAdapter(endlessRecyclerViewAdapter);

// Change the states of the adapter
statesRecyclerViewAdapter.setState(StatesRecyclerViewAdapter.STATE_LOADING);
statesRecyclerViewAdapter.setState(StatesRecyclerViewAdapter.STATE_EMPTY);
statesRecyclerViewAdapter.setState(StatesRecyclerViewAdapter.STATE_ERROR);
statesRecyclerViewAdapter.setState(StatesRecyclerViewAdapter.STATE_NORMAL);
```

You can have a look at the example project for more details.

## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/rockerhieu/rv-adapter-states/pulls).

Any contributions, large or small, major features, bug fixes, additional
language translations, unit/integration tests are welcomed and appreciated
but will be thoroughly reviewed and discussed.

## License

```
The MIT License (MIT)

Copyright (c) 2015 Hieu Rocker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
