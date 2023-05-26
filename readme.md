# Paint 2.0
## Description
VU MIF 2nd semester java project. Simple paint-like app, allowing to draw simple shapes and save them.
## Run
Run file `Paint_2_0.jar`
## Features
- 3 shapes to draw: rectangle, circle, line;
- Ability to choose filled shapes;
- Shape editing: cloning, deleting;
- Image saving/loading with file dialog window.

 ## Main classes

  - `Main` - creates an instance of MyFrame class;
  - `MyFrame` - contains all components, including MyPanel instance and all the buttons. Implements all listeners.
  - `MyPanel` - main drawing component, contains LinkedList of existing shapes;
  - `Shape` - Abstract shape class, contains all general shape properties;
  - `ShapeFactory` - factory, creates instances of shapes;
  - `MyThreadOutput` - runs a new thread and allows user to save existing image to a file via file manager;
  - `MyThreadInput` - runs a new thread and allows user to load saved file via file manager.

  ## Patterns
  - `ShapeFactory` - factory pattern;
  - `Shape implements Cloneable` - marker interface pattern.
 


