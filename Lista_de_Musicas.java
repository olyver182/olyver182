

public class Lista_de_Musicas 
{
	public static final int length = 0;
	private String artista;
	private String titulo;
	private String album;
	String genero;
	private String ano;
	private String duração;
	public String banda;
	
	public Lista_de_Musicas() {
		return;
		
	}
	
	public Lista_de_Musicas(String artista, String titulo, String album, String genero, String ano, String duração) {
		this.artista = artista;
		this.titulo = titulo;
		this.album = album;
		this.genero = genero;
		this.ano = ano;
		this.duração = duração;
	
	}

	public void setArtista(String artista){
		this.artista = artista;
	}
	public String getArtista(){
		return artista;
	}
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public String getTitulo(){
		return titulo;
	}
	public void setAlbums(String album){
		this.album = album;
	}
	public String getAlbum() {
		return album;
	}
	public void setGenero(String genero){
		this.genero = genero;
	}
	public String getGenero(){
		return genero;
	}	
	public void setAnos(String ano){
		this.ano = ano;
	}
	
	public String getAnos(){
		return ano;
	}
	public void setDuração(String Duração ) {
        this.duração = Duração;
	}

	public CharSequence getDuração(){
        return duração;
	}
	public String toString() {
       return this.ano + ": " + this.duração;
	}

	 
} 