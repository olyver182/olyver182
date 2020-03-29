public class Principal
{
	public static void main( String[] arg)
	{
		Cadastrar menu = new Cadastrar();
		menu.loadPlaylist();
		menu.executarMenu();
	}
}