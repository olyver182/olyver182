import java.util.*;

public class Playlist  
{
	private ArrayList<Lista_de_Musicas> playlist;
	public Playlist()
	{
	playlist = new ArrayList<Lista_de_Musicas>();
	}
	public void novaMusica(Lista_de_Musicas musica)
	{
	playlist.add(musica);
	}
	public int getPlaylistSize()
	{
	  return playlist.size();
	}
	public String getArtista(int index)
	{
	  return playlist.get(index).getArtista();
	}
  public String getTitulo(int index)
	{
	  return playlist.get(index).getTitulo();
	}
	public String getAlbum(int index)
	{
	  return playlist.get(index).getAlbum();
	}
	public String getGenero(int index) {
	
		return playlist.get(index).getGenero();
	}
	public String getAno(int index)
	{
		return playlist.get(index).getAnos();
	}
	public CharSequence getDura��o(int index)
	{
		return playlist.get(index).getDura��o();
	}
	public void updateArtist(int index, String artist)
	{
		playlist.get(--index).setArtista(artist);
	}
	public void updateTitulo(int index, String titulo)
	{
		playlist.get(--index).setTitulo(titulo);
	}

	public void updateAlbum(int index, String album)
	{
		playlist.get(--index).setAlbums(album);
	}
	public void updateGenero(int index, String genero)
	{
		playlist.get(--index).setGenero(genero);
	}
	public void updateAno(int index, String ano) {
  	playlist.get(--index).setAnos(ano);
	}
	public void updateDura��o(int index, String dura��o) {
		playlist.get(--index).setDura��o(dura��o);
	}
	public void updateDura��o(int songSelection, int dura��o) {
		playlist.get(--dura��o);
			
	}
	public void removeSong(int index)
	{
	  playlist.remove(index);
	}
	public void deletePlaylist()
	{
		if(playlist.size() == 0)
		{
			System.out.print("Lista vazia!!\n");
		}
		else
		{
			playlist.clear();
			System.out.print("A lista foi exclu�da.\n");
		}
	}
	public void novaMusica(String novaMusica1) {
		// TODO Auto-generated method stub
		
	}
		
}	