# openMap4u Codebase Explanation

## 1. Project Overview
`openMap4u` is a Java-based open-source data mapping library. It allows users to create visualizations (maps, charts, diagrams) on a 2D plane and export them to various formats like PNG or SVG.

## 2. Module Structure
The project is organized as a Maven multi-module project:

*   **`openmap4u-parent`**: The root module managing dependencies and build configuration.
*   **`openMap4u-core`**: The core library containing the main logic, interfaces, and default implementations.
*   **`openMap4u-data`**: Contains test data.
*   **`openMap4u-spatial-plugin`**: Plugin for spatial functionality (integration with GeoTools).
*   **`openMap4u-integration-examples`**: Examples of how to integrate the library into other applications.

## 3. Core Architecture (openMap4u-core)
The library extensively uses a **Fluent API** and the **Builder Pattern** to provide a readable and flexible interface.

### Key Components

*   **`OpenMap4u`**: The main entry point. It manages default configurations (units, styles) and acts as a factory for `Canvas` and `Builder` instances.
*   **`Canvas`**: Represents the drawing surface. It handles the viewport (size, scale, rotation, center) and delegates rendering to an `Outputable`.
*   **`Builder` / `BuildablePrimitive`**: A hierarchy of classes to construct shapes, text, and images. It supports method chaining for setting properties like style, visibility, and transformation.
    *   Examples: `Line`, `Polyline`, `Rectangle`, `Circle`, `Text`, `Image`.
*   **Plugins**: The library is designed to be extensible.
    *   `org.openmap4u.plugin.builder`: Contains specific implementations for shapes and charts.
    *   `org.openmap4u.plugin.format`: Contains output format implementations (e.g., `Png`, `Svg`).
*   **`Outputable`**: Interface for the rendering engine. The default implementation uses Java 2D (`Graphics2D`).

## 4. Usage Flow
The typical usage pattern involves:

1.  **Initialization**: Create an instance of `OpenMap4u`.
2.  **Canvas Creation**: Call `openMap4u.getCanvas(width, height)` to define the drawing area.
3.  **Building Elements**: Use `openMap4u.get(BuilderClass.class)` to get a builder instance. Configure it using fluent methods (e.g., `.style()`, `.rotate()`, `.visible()`).
4.  **Drawing**: Call `canvas.draw(builder)`. The canvas transforms the primitives and sends them to the `Outputable`.
5.  **Output**: Call `canvas.write(outputStream)` or `canvas.write(path)` to save the result.

## 5. Identified Issues
During the analysis, the following issues were identified:

1.  **Bug in `ShapeBuilder.java`**:
    In `src/main/java/org/openmap4u/geom/ShapeBuilder.java`, the `shape(Shape shape)` method initializes `coords` to `null`:
    ```java
    double[] coords = null;
    while (!iterator.isDone()) {
        int fragType = iterator.currentSegment(coords); // Throws NPE
    ```
    `PathIterator.currentSegment` requires an array of at least 6 elements. It should be initialized as `double[] coords = new double[6];`.

2.  **Build Configuration**:
    The `pom.xml` references insecure HTTP repositories (e.g., `http://download.osgeo.org`), which are blocked by modern Maven versions. This prevents the project from building successfully without configuration changes.
