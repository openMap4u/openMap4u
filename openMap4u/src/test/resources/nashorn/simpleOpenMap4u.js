/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var CollectionsAndFiles = new JavaImporter(
        org.openmap4u,
        java.util,
        java.io,
        java.nio);
with (CollectionsAndFiles) {
    var outputFile = java.nio.file.FileSystems.getDefault().getPath(".", "target", "test-classes", "nashorn", "simpleLine.png");
    var oM4u = new org.openmap4u.OpenMap4u();
    var canvas = oM4u.getCanvas(10, 8);
    canvas.draw(oM4u.create(org.openmap4u.plugin.builder.core.Line.class).line(1, 1, 9, 7));
    canvas.write(outputFile);
}

