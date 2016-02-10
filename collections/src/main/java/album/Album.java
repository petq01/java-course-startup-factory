/**
 * 
 */
package album;

/**
 * @author Petq
 *
 */
public class Album {
	private String nameAlbum;
	private int totalSongs;

	public String getNameAlbum() {
		return nameAlbum;
	}

	public void setNameAlbum(String nameAlbum) {
		this.nameAlbum = nameAlbum;
	}

	public int getTotalSongs() {
		return totalSongs;
	}

	public void setTotalSongs(int totalSongs) {
		this.totalSongs = totalSongs;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The name of the album is is: ").append(nameAlbum).append(". totalOfSongs: ").append(totalSongs);
		return sb.toString();
	}

	public Album(String nameAlbum, int totalSongs) {
		this.nameAlbum = nameAlbum;
		this.totalSongs = totalSongs;
	}

}
