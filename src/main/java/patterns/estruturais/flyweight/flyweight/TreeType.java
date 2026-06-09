package patterns.estruturais.flyweight.flyweight;

/**
 * Classe que atua como o Flyweight (Peso-Mosca).
 * Contém o estado intrínseco que pode ser compartilhado por vários objetos individuais.
 * O estado intrínseco é imutável após a criação.
 */
public class TreeType {
    
    private final String name;
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getTexture() {
        return texture;
    }

    /**
     * Desenha a árvore passando o estado extrínseco (coordenadas x, y) como argumentos do método.
     * @param x coordenada X (estado extrínseco)
     * @param y coordenada Y (estado extrínseco)
     */
    public void draw(int x, int y) {
        System.out.println("Desenhando arvore do tipo '" + name + "' [Cor: " + color + ", Textura: " + texture + "] nas coordenadas (" + x + ", " + y + ")");
    }
}
